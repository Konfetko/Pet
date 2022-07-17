import React, {useEffect, useState} from 'react';
import cls from '../scss/MainPage.module.scss';
import axios from 'axios'
import APILink from "../resources/APILink";
import Layout from "../components/Layout";
import TodoList from "../components/TodoList";
import {useNavigate} from "react-router-dom";

const MainPage = ({user}) => {
    let [todos,setTodos]=useState([])
    let navigate = useNavigate()
    function getUser(){
        if(user.idUser===0)
            navigate("/")

        axios.get(APILink+"/todos/"+user.idUser)
            .then(
                res=>{
                    setTodos(res.data.todos.sort((x,y)=>x.title>y.title?1:-1))
                }
            )
    }
    function doTodo(idTodo){

        axios.get(APILink+`/todo/${idTodo}`)
            .then(res=>{
                const todo = todos.filter(x=>x.idTodo===idTodo)[0]
                todo.checked=!todo.checked
                getUser()
            })
            .catch(x=>console.log(x))
    }
    function removeTodo(idTodo){
        axios.post(APILink+`/removetodo?todoId=`+idTodo)
            .then(res=>{
                getUser()
            })
            .catch(x=>console.log(x))

    }


    useEffect( getUser,[])

    return (
       <Layout>
           <div className={cls.backLayout}>
               <TodoList todos={todos} check={doTodo} remove={removeTodo}/>
           </div>
       </Layout>
    );
};

export default MainPage;