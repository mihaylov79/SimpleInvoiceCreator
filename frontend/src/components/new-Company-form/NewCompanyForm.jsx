import {useState} from "react";


export default function NewCompanyForm(){

    const [formData, setFormData] = useState({
        companyName: "",
        EIK: "",
        vatRegistered: false,
        vatN:"",
        homeTown: "",
        address: "",
        contactEmail:"",
        responsiblePerson:"",
        owner: null,
        accountant:null,
        bank:null,
        BIC:null,
        IBAN:"",
        bankDepartment:null
    });

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);
    const baseUrl = "http://localhost:8080/api/v1.0/companies/new-company"

    const changeHandler = (e) => {
        const {name, value, type, checked} = e.target;
        setFormData((prev) =>({
            ...prev, [name]: type === "checkbox" ? checked : value
        }));
    }

    const submitHandler = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError(null);
        setSuccess(null);
        try{

            const response = await fetch(baseUrl, {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(formData)
            });

            if (!response.ok) {
                const errorBody = await response.text();
                console.log("Status:", response.status);
                console.log("Response Text:", errorBody);
                throw new Error("Грешка" + errorBody);
            }

            setSuccess("Фирмата е създадена успещно!");
            setFormData({
                companyName: "",
                EIK: "",
                vatRegistered: false,
                vatN:"",
                homeTown: "",
                address: "",
                contactEmail:"",
                responsiblePerson:"",
                owner: null,
                accountant:null,
                bank:null,
                BIC:null,
                IBAN:"",
                bankDepartment:null
            });
        }catch (err){
            console.log(err);
            setError(err.message)
        }finally {
            setLoading(false)
        }
    };

    return(
        <div>
            <div>
                <h2>Добавете нова фирма</h2>
            </div>
            <div>
                <form onSubmit={submitHandler}>
                    <label>Име на фирмата:</label><br />
                    <input
                    name="companyName"
                    value={formData.companyName}
                    onChange={changeHandler} required/><br />

                    <label>ЕИК:</label><br />
                    <input
                    name="EIK"
                    value={formData.EIK}
                    onChange={changeHandler} required pattern="\d{10}" /><br />

                    <label>
                    <input
                    type="checkbox"
                    name="vatRegistered"
                    value={formData.vatRegistered}
                    onChange={changeHandler} /> Регистрация по ЗДДС</label><br/>

                    <label>ЗДДС Номер:</label><br/>
                    <input
                    name="vatN"
                    value={formData.vatN}
                    onChange={changeHandler}/><br/>

                    <label>Град:</label><br/>
                    <input
                    name="homeTown"
                    value={formData.homeTown}
                    onChange={changeHandler}/><br/>

                    <label>Адрес:</label><br/>
                    <input
                    name="address"
                    value={formData.address}
                    onChange={changeHandler} required /><br/>

                    <label>Поща:</label><br/>
                    <input
                    name="contactEmail"
                    value={formData.contactEmail}
                    onChange={changeHandler}/><br/>

                    <label>МОЛ:</label><br/>
                    <input
                     name="responsiblePerson"
                     value={formData.responsiblePerson}
                     onChange={changeHandler} required /><br/>

                    <label>IBAN:</label><br/>
                    <input
                        name="IBAN"
                        value={formData.IBAN}
                        onChange={changeHandler}/><br/>

                    <button type="submit" disabled={loading}>
                        {loading ? "Изпращане..." : "Създай фирма"}
                    </button>
                </form>
                {error && <p style={{ color: "red" }}>⚠ {error}</p>}
                {success && <p style={{ color: "green" }}>✅ {success}</p>}
            </div>
        </div>
    );
}
