import React, { useRef, useEffect, useState } from 'react';
import mapboxgl from '!mapbox-gl'; // eslint-disable-line import/no-webpack-loader-syntax
 
mapboxgl.accessToken = process.env.MAPBOX_API_KEY;

export default function Map( { findByStateName }) {
    const mapContainer = useRef(null);
    const map = useRef(null);
    const [lng, setLng] = useState(-99.052734);
    const [lat, setLat] = useState(39.436193);
    const [zoom, setZoom] = useState(3.5);

    useEffect(() => {
        if (map.current) return; // initialize map only once
        map.current = new mapboxgl.Map({
            container: mapContainer.current,
            style: 'mapbox://styles/mapbox/streets-v12',
            center: [lng, lat],
            zoom: zoom
        });

        map.current.on('load', () => {
            map.current.setFog({});

            map.current.addSource('state-boundaries', {
                type: 'geojson',
                data: "state-boundaries.json"
            });

            map.current.addLayer({
                id: 'state-boundaries-fill',
                type: 'fill',
                source: 'state-boundaries',
                paint: {
                    'fill-color': 'steelblue',
                    'fill-opacity': 0.4
                }
            })
            map.current.addLayer({
                id: 'state-boundaries-line',
                type: 'line',
                source: 'state-boundaries',
                paint: {
                    'line-color': 'white',
                    'line-width': 3,
                    'line-opacity': 0.8
                }
            })
        })
        map.current.on('click', 'state-boundaries-fill', (e) => {
            let currentChoice = e.features[0].properties.NAME;
            findByStateName(currentChoice);
        });
    });

    return (
        <div>
            <div ref={mapContainer} className="map-container" />
        </div>
    );

}