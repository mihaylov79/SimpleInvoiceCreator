import { useState } from "react";
import styles from "../login-form/LoginForm.module.css"


export default function RegisterForm()  {
const [pending, setPending] = useState(false);

const [value, setValues] = useState({

username: "",
password: "",
email: "",
firstName: "",
lastName: "",
birthDate: "",
company: "",

})

const submitHandler = async(e) => {
    setPending(true);

    e.preventDefault();

    // I should Call Api Here

    setPending(false);
}

const onChangeHandler = (e) => {

    setValues((state) => ({...state, [e.target.name]:e.target.value}))
}

return(
    <div className= {styles.formMainContainer}>
        <div className= {styles.formContainer}>
            <h2>Регистрация</h2>

            <form onSubmit={submitHandler}>
                <div className= {styles.fieldContainer}>
                    <label htmlFor="username">Потребителско име</label>
                    <input type="text"
                            id="username"
                            name="username"
                            value={value.username}
                            onChange={onChangeHandler} />
                </div>
                <div className= {styles.fieldContainer}>
                    <label htmlFor="password">Парола</label>
                    <input type="password"
                            id="password"
                            name="password"
                            value={value.password}
                            onChange={onChangeHandler} />
                </div>
                <div className= {styles.fieldContainer}>
                <label htmlFor="firstName">Име</label>
                <input type="text"
                        id="firstName"
                        name="firstName"
                        value={value.firstName}
                        onChange={onChangeHandler} />
                </div>
                <div className= {styles.fieldContainer}>
                    <label htmlFor="lastName">Фамилия</label>
                    <input type="text"
                            id="lastName"
                            name="lastName"
                            value={value.lastName}
                            onChange={onChangeHandler} />
                </div>
                <div className= {styles.fieldContainer}>
                    <label htmlFor="email">Ел.Поща</label>
                    <input type="email"
                            id="email"
                            name="email"
                            value={value.email}
                            onChange={onChangeHandler} />
                </div>
                <div className= {styles.fieldContainer}>
                    <label htmlFor="birthDate">Дата на раждане</label>
                    <input type="date"
                            id="birthDate"
                            name="birthDate"
                            value={value.birthDate}
                            onChange={onChangeHandler} />

                </div>
                <div className= {styles.fieldContainer}>
                    <label htmlFor="company">Компания</label>
                    <input type="text"
                            id="company"
                            name="company"
                            value={value.company}
                            onChange={onChangeHandler} />

                </div>
                <div className= {styles.fieldContainer}>
                    <input type="submit"
                            value= "Регистрация"
                            disabled = {pending}  />
                </div>

            </form>
        </div>
    </div>

);

}