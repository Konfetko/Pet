import React, {useState} from 'react';
import cls from '../scss/AddPage.module.scss'
import axios from 'axios'
import APILink from "../resources/APILink";
import Button from "../components/Button";
import Layout from "../components/Layout";

const AddPage = ({user}) => {
    let [todoContent,setTodoContent]=useState("")
    let [contentLength,setContentLength]=useState(0)
    function addTodo(){
        axios.post(APILink+`/createtodo?userId=`+user.idUser,{title:todoContent,checked:false})
    }
    return (
        <Layout>
            <div className={cls.form}>
                <input type="text" placeholder={"Задача"} onChange={(e)=>{
                    setTodoContent(e.target.value)
                    setContentLength(e.target.value.length)
                }}/>
                <div className={cls.container}>
                    <Button onClick={addTodo}>
                        Добавить
                    </Button>
                    <div className={cls.limitation}>
                        {contentLength} / 255
                    </div>
                </div>
            </div>
        </Layout>
    );
};

export default AddPage;