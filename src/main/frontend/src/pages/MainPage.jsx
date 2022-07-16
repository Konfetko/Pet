import React, {useEffect, useState} from 'react';
import cls from '../scss/MainPage.module.scss';
import axios from 'axios'
import APILink from "../resources/APILink";
import Layout from "../components/Layout";
import TodoList from "../components/TodoList";

const MainPage = ({user}) => {
    //let [user,setUser]=useState(null)
    let [todos,setTodos]=useState([])
    function getUser(){
        axios.get(APILink+"/todos/"+user.idUser)
            .then(
                res=>{
                    setTodos(res.data.todos.sort((x,y)=>x.title>y.title?1:-1))
                }
            )
    }
    function doTodo(idTodo){
        axios.get(APILink+`/todo/${user.idUser}&${idTodo}`)
            .then(res=>{
                const todo = todos.filter(x=>x.idTodo==idTodo)[0]
                todo.checked=!todo.checked
                getUser()
            })
            .catch(x=>console.log(x))
    }


    useEffect( getUser,[])

    return (
       <Layout>
           <div className={cls.backLayout}>
               <TodoList todos={todos} check={doTodo}/>
           </div>
       </Layout>
    );
};

export default MainPage;