import React, { useState } from "react";
import FolTable from "../components/FolTable";
import Loader from "../components/Loader";
import folService from "../services/FolService";
import * as IoIcons from "react-icons/io"
import { Button } from "react-bootstrap";
import CreateFolModal from "../components/CreateFolModal";

export default function Fols() {

    const [fols, setFols] = useState(undefined);
    const [loading, setLoading] = useState(false);
    const [showModalCreateFol, setShowModalCreateFol] = useState(false);

    function buscar() {
        setLoading(true);
        folService.findAll().then((result) => {
            setFols(result);
            setLoading(false);
        }).finally(() => {
            setLoading(false);
        });
    }

    function createFol(){
        return null;
    }

    return (
        <>
            <div className="container">
                <span className="title">FOLs</span>
                <Button onClick={buscar}><IoIcons.IoIosRefresh/></Button>
                <Button variant="primary" onClick={() => setShowModalCreateFol(true)}>Create new FOL</Button>
                <FolTable fols={fols}/>
            </div>
            {loading && <Loader />}
            {showModalCreateFol && <CreateFolModal fol={null}
                                    onChange={null}
                                    showModal={showModalCreateFol}
                                    onClose={() => setShowModalCreateFol(!showModalCreateFol)}
                                    onSubmit={createFol}/>
            }
        </>
    )
}