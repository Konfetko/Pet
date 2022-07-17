import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom'
import cls from '../scss/AuthPage.module.scss'
import axios from 'axios'
import APILink from "../resources/APILink";
import Button from '../components/Button'

const AuthPage = ({createUser}) => {
    const navigate = useNavigate()
    const [user,setUser]=useState({login:"",pass:"",email:""})
    const [loginning,setLoginning]=useState(true)
    function registration(){

    }
    function accessCheck(e){
        e.preventDefault()
        axios.post(APILink+`/userAuth`,user).then(res=>{
            if(res.data!=null){
                createUser(res.data)
                navigate("/mainPage")
            }
        }).catch(console.log)
    }
    const authorithationForm=()=>{
        return (
            <form className={cls.form}>
                <div>
                    <ul className={cls.list}>
                        <li>
                            <input type="text"  placeholder={"Логин"} onChange={(e)=>setUser({...user,login:e.target.value})}/>
                        </li>
                        <li>
                            <input type="text"  placeholder={"Пароль"} onChange={(e)=>setUser({...user,pass:e.target.value})}/>
                        </li>
                        <li>
                            <Button onClick={accessCheck} className={cls.center}>Войти</Button>
                        </li>
                        <li >
                            <button onClick={()=>setLoginning(false)} className={cls.transferButton+" "+cls.center}>Регистрация</button>
                        </li>
                    </ul>
                </div>
            </form>
        )
    }
    const registrationForm=()=>{
        return (
            <form className={cls.form}>
                <div>
                    <ul className={cls.list}>
                        <li>
                            <input type="text"  placeholder={"Логин"} onChange={(e)=>setUser({...user,login:e.target.value})}/>
                        </li>
                        <li>
                            <input type="text"   placeholder={"Пароль"} onChange={(e)=>setUser({...user,password:e.target.value})}/>
                        </li>
                        <li>
                            <input type="text"   placeholder={"Email"} onChange={(e)=>setUser({...user,email:e.target.value})}/>
                        </li>
                        <li>
                            <Button className={cls.center} onClick={registration}>Зарегистрироваться</Button>
                        </li>
                        <li>
                            <button onClick={()=>setLoginning(true)} className={cls.transferButton+" "+cls.center}>Авторизация</button>
                        </li>

                    </ul>
                </div>
            </form>
        )
    }
    return (
        (loginning)
        ?authorithationForm()
            :registrationForm()

    );
};

export default AuthPage;