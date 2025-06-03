
import {Link} from 'react-router';
import "../css/Nav.css"

export default function NavBar(){
    return(
        <div className="nav-container">
            <nav>
                <Link to="/">Начало</Link>
                <div className="dropDown">
                    <span className="dropBtn">Фирми</span>
                    <ul className="dropContent">
                        <li><Link to="/api/v1.0/companies/create">Добави нова</Link></li>
                        {/*<li><Link to="/api/v1.0/companies/edit/{companyId}">Редактиране</Link></li>*/}
                        <li><Link to="/api/v1.0/companies/list">Всички</Link></li>
                    </ul>
                </div>
                <Link to="/register">Регистрация</Link>
                <Link to="/login">Вход</Link>


            </nav>
        </div>


    )
}