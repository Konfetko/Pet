import React from 'react';
import cls from '../scss/AddPage.module.scss'
import axios from 'axios'
import APILink from "../resources/APILink";
import Button from "../components/Button";

const AddPage = ({user}) => {
    function addTodo(){
        axios.post(APILink+`/createtodo?userId=`+1,{title:"222222",checked:false})
    }
    return (
        <div>
            <input type="text" placeholder={"Задача"}/>
            <Button onClick={addTodo}>
                Добавить
            </Button>
        </div>
    );
};

export default AddPage;