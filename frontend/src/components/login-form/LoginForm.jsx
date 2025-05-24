import { useState } from "react";
import styles from "./LoginForm.module.css";

 export default function LoginForm () {
    const [pending, setPending] = useState(false);

    const [values, setValues] = useState ({

        username:'',
        password: '',
        remember: false,
 })

 const submitHandler= async(e) => {
    setPending(true);

    e.preventDefault();

    // I should Call Api Here

    setPending(false);
 }

 const changeHandler = (e) => {
   setValues(state => ({...state, [e.target.name]:e.target.type=== 'checkbox' ? e.target.checked : e.target.value}))
 } 

 return (
      <div className= {styles.formMainContainer}>
         
         <div className= {styles.formContainer}>
            <h2>Вход</h2>
            <form onSubmit={submitHandler}>
               <div className={styles.fieldContainer}>
                  <label htmlFor="username">Потребителско име</label>
                  <input type="text"
                           id="username"
                           name="username"
                           value={values.username}
                           onChange={changeHandler} />
               </div>
               <div className= {styles.fieldContainer}>
                  <label htmlFor="password">Парола</label>
                  <input type="password"
                           id="password"
                           name="password"
                           value={values.password}
                           onChange={changeHandler} />
               </div>
               <div className= {styles.fieldContainer}>
                  <label htmlFor={styles.remember}>Запомни ме</label>
                  <input type="checkbox"
                           id="remember"
                           name="remember"
                           checked={values.remember}
                           onChange={changeHandler} />
               </div>
               <div className= {styles.fieldContainer}>
                  <input type="submit"
                        value="Вход"
                        disabled={pending} />
               </div>
            </form>

          </div> 
      </div>     
 );
}