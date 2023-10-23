import { useEffect, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "../context/AuthContext";

function Home() {

  const auth = useContext(AuthContext);

  const navigate = useNavigate();
  
  return 
    <>
        <p>Home Page</p>
    </>
}

export default Home;
