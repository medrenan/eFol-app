import React, { useState } from "react";
import EquipmentTable from "../components/EquipmentTable";
import Loader from "../components/Loader";
import categoryService from "../services/CategoryService";
import * as IoIcons from "react-icons/io"
import { Button } from "react-bootstrap";
import CategoryTable from "../components/CategoryTable";

export default function Categories() {

    const [categories, setCategories] = useState(undefined);
    const [loading, setLoading] = useState(false)

    function buscar() {
        setLoading(true);
        categoryService.findAll().then((result) => {
            setCategories(result);
            setLoading(false);
        }).finally(() => {
            setLoading(false);
        });
    }

    return (
        <>
            <div className="container">
                <span className="title">Categories</span>
                <Button onClick={buscar}><IoIcons.IoIosRefresh/></Button>
                <CategoryTable categories={categories}/>
            </div>
            {loading && <Loader />}
        </>
    )
}