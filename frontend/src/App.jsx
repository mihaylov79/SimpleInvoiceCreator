import { useState } from 'react'
// import './App.css'
import Home from "./components/home/Home.jsx";
import NavBar from "./components/nav-bar/NavBar.jsx";
import {Route, Routes} from "react-router";
import LoginForm from "./components/login-form/LoginForm.jsx";
import RegisterForm from "./components/register-form/RegisterForm.jsx";
import CompaniesList from "./components/companies-list/CompaniesList.jsx";

function App() {

  return (
    <>
        <header>
            <div>
                <NavBar />

                <Routes>
                    <Route path={"/"} element={<Home/>}/>
                    <Route path={"/companies/list"} element={<CompaniesList/>}/>
                    <Route path={"/login"} element={<LoginForm/>}/>
                    <Route path={"/register"} element={<RegisterForm/>}/>


                </Routes>
            </div>
        </header>
    </>
  )
}

export default App
