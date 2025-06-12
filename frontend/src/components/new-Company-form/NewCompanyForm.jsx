import {useState} from "react";
import styles from "../login-form/LoginForm.module.css";


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
        <div className= {styles.formMainContainer}>
            <div className= {styles.formContainer}>
                <h2>Добавете нова фирма</h2>

            <div>
                <form onSubmit={submitHandler}>
                    <div className= {styles.fieldContainer}>
                        <label>Име на фирмата:</label><br />
                        <input type="text"
                               id="companyName"
                                name="companyName"
                                value={formData.companyName}
                                onChange={changeHandler} required/><br />
                    </div>
                    <div className= {styles.fieldContainer}>
                        <label>ЕИК:</label><br />
                        <input type="text"
                               id="EIK"
                                name="EIK"
                                value={formData.EIK}
                                onChange={changeHandler} required /><br />
                    </div>
                    <div className= {`${styles.fieldContainer} ${styles.vatContainer}`}>
                        <label className={styles.checkboxLabel}> Регистрация по ЗДДС
                        <input type="checkbox"
                               id="vatRegistered"
                                name="vatRegistered"
                                checked={formData.vatRegistered}
                                onChange={changeHandler} /></label><br/>
                    </div>
                    <div className= {styles.fieldContainer}>
                        <label>ЗДДС Номер:</label><br/>
                        <input type="text"
                               id="vatN"
                                name="vatN"
                                value={formData.vatN}
                                onChange={changeHandler}/><br/>
                    </div>

                    <div className= {styles.fieldContainer}>
                        <label>Град:</label><br/>
                        <input type="text"
                               id="homeTown"
                                name="homeTown"
                                value={formData.homeTown}
                                onChange={changeHandler}/><br/>
                    </div>
                    <div className= {styles.fieldContainer}>
                        <label>Адрес:</label><br/>
                        <input type="text"
                               id="address"
                                name="address"
                                value={formData.address}
                                onChange={changeHandler} required /><br/>
                    </div>
                    <div className= {styles.fieldContainer}>
                        <label>Поща:</label><br/>
                        <input type="email"
                               id="contactEmail"
                                name="contactEmail"
                                value={formData.contactEmail}
                                onChange={changeHandler}/><br/>
                    </div>
                    <div className= {styles.fieldContainer}>
                        <label>МОЛ:</label><br/>
                        <input type="text"
                               id="responsiblePerson"
                                 name="responsiblePerson"
                                 value={formData.responsiblePerson}
                                 onChange={changeHandler} required /><br/>
                    </div>
                    <div className= {styles.fieldContainer}>
                        <label>IBAN:</label><br/>
                        <input type="text"
                               id="IBAN"
                                name="IBAN"
                                value={formData.IBAN}
                                onChange={changeHandler}/><br/>
                    </div>
                    <div>
                    <button className={styles.createCompanyBtn} type="submit" disabled={loading}>
                        {loading ? "Изпращане..." : "Създай фирма"}
                    </button>
                    </div>
                </form>
                {error && <p style={{ color: "red" }}>⚠ {error}</p>}
                {success && <p style={{ color: "green" }}>✅ {success}</p>}
            </div>
            </div>
        </div>
    );
}
