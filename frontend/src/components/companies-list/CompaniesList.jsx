import {useEffect, useState} from "react";
import {ClipLoader} from "react-spinners";

export default function CompaniesList() {
    const [companies, setCompanies] = useState([])
    const [loading, setLoading] = useState(true)
    const baseUrl = "/api/companies/list";

    useEffect(() => {
        const fetchCompanies = async () => {
            try {
                const response = await fetch(baseUrl);

                if (!response.ok) {
                    throw  new Error("HTTP грешка: " + response.status)
                }
                const companyData = await response.json();
                setCompanies(companyData)

            }catch (err) {
                console.error("Грешка при зареждане на фирмите ", err.message);
            }finally {
                setLoading(false)
            }
        }

        fetchCompanies();

    },[]);

    if (loading){
        return <ClipLoader color= {"#a7e9db"} size = {35} />
    }

    if (!loading && companies.length === 0) {
        return <p>Няма намерени фирми.</p>;
    }

    return (
        <div>
            <h2>Списък с фирми</h2>
            <ul>
                {companies.map(c => (
                    <li key={c.id}>{c.companyName} — {c.homeTown}</li>
                ))}
            </ul>
        </div>
    );
}

