import React from 'react';
import Button from './Button'
import cls from '../scss/TodoList.module.scss'

const TodoList = (props) => {

    return (
        <div>
            {
                props.todos.map(x=>
                    <div className={(x.checked?cls.checked:cls.default)+" "+cls.container}>
                        <table className={cls.todoContainer}>

                            <tr> <h2>{x.title}</h2></tr>
                            <tr>
                                <td>
                                    <Button onClick={()=>props.check(x.idTodo)}>
                                        {x.checked?"Заново":"Закончить"}
                                    </Button>
                                </td>
                                <td>
                                    <Button >Удалить</Button>
                                </td>
                            </tr>
                        </table>
                    </div>
                )
            }
        </div>
    );
};

export default TodoList;