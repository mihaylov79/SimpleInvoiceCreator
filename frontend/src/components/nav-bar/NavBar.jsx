
import {Link} from 'react-router';
import "../css/Nav.css"

export default function NavBar(){
    return(
        <div className="nav-container">
            <nav>
                <Link to="/">Начало</Link>
                <Link to="/register">Регистрация</Link>
                <Link to="/login">Вход</Link>
            </nav>
        </div>


    )
}