import React from 'react';
import Button from './Button'
import cls from '../scss/TodoList.module.scss'

const TodoList = (props) => {

    return (
        <div>
            {
                props.todos.map(x=>
                    <div key={x.idTodo} className={(x.checked?cls.checked:cls.default)+" "+cls.container}>
                        <div className={cls.todoContainer} >

                            <div className={cls.content}>{x.title}</div>
                            <div>
                                <Button onClick={()=>props.check(x.idTodo)}>
                                    {x.checked?"Заново":"Закончить"}
                                </Button>

                                <Button onClick={()=>props.remove(x.idTodo)}>Удалить</Button>
                            </div>

                        </div>
                    </div>
                )
            }
        </div>
    );
};

export default TodoList;