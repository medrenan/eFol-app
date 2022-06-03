import React, { useState } from "react";
import EquipmentTable from "../components/EquipmentTable";
import Loader from "../components/Loader";
import keywordService from "../services/KeywordService";
import * as IoIcons from "react-icons/io"
import { Button } from "react-bootstrap";
import KeywordTable from "../components/KeywordTable";

export default function Equipments() {

    const [keywords, setKeywords] = useState(undefined);
    const [loading, setLoading] = useState(false)

    function buscar() {
        setLoading(true);
        keywordService.findAll().then((result) => {
            setKeywords(result);
            setLoading(false);
        }).finally(() => {
            setLoading(false);
        });
    }

    return (
        <>
            <div className="container">
                <span className="title">Keywords</span>
                <Button onClick={buscar}><IoIcons.IoIosRefresh/></Button>
                <KeywordTable keywords={keywords}/>
            </div>
            {loading && <Loader />}
        </>
    )
}