import React from "react";
import Table from 'react-bootstrap/Table'

export default function EquipmentTable({equipments}){

    function renderTableRows() {
        if(!equipments) {
            return;
        }

        return equipments.map((equipment: any) => {
            return <tr>
                <td>{equipment.id}</td>
                <td>{equipment.name}</td>
            </tr>
        })
    }

    return (
        <>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    {renderTableRows()}
                </tbody>
            </Table>
        </>
    )
}