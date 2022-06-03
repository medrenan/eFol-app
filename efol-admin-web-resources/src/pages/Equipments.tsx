import React, { useState } from "react";
import EquipmentTable from "../components/EquipmentTable";
import Loader from "../components/Loader";
import equipmentService from "../services/EquipmentService";
import * as IoIcons from "react-icons/io"
import { Button } from "react-bootstrap";

export default function Equipments() {

    const [equipments, setEquipments] = useState(undefined);
    const [loading, setLoading] = useState(false)

    function buscar() {
        setLoading(true);
        equipmentService.findAll().then((result) => {
            setEquipments(result);
            setLoading(false);
        }).finally(() => {
            setLoading(false);
        });
    }

    return (
        <>
            <div className="container">
                <span className="title">Equipments</span>
                <Button onClick={buscar}><IoIcons.IoIosRefresh/></Button>
                <EquipmentTable equipments={equipments}/>
            </div>
            {loading && <Loader />}
        </>
    )
}