import React from 'react';
import cls from '../scss/Button.module.scss'

const Button = (props) => {
    return (
        <button className={cls.button +" "+ props.className} onClick={props.onClick}>
            {props.children}
        </button>
    );
};

export default Button;