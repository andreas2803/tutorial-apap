import React from "react";
import classes from "./styles.module.css";
import Button from "../button";

const Item = (props) => {
    const { id, title, price, description, category, handleEdit, handleDelete} = props;
    return (
    <div className={classes.item}>
    <h3>{`ID ${id}`}</h3>
    <p>{`Nama Barang: ${title}`}</p>
    <p>{`Price: ${price}`}</p>
    <p>{`Description: ${description}`}</p>
    <p>{`Category: ${category}`}</p>
    <Button action={handleEdit}>
    Edit
    </Button>
    <Button action={handleDelete}>
    Delete
    </Button>
    </div>
    );
};
export default Item;