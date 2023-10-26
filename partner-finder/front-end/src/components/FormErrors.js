export default function FormErrors({ errors }) {
    if (!errors || !errors.length) {
        return null;
    }

    return (
        <div className="alert alert-danger">
            <ul className="mb-0">
                <p>Failed due to the following errors:</p>
                {errors.map(err => <li key={err}>{err}</li>)}
            </ul>
        </div>
    );
}