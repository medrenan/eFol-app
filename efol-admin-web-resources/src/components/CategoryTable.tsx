import React from "react";
import Table from 'react-bootstrap/Table'

export default function CategoryTable({categories}){

    function renderTableRows() {
        if(!categories) {
            return;
        }

        return categories.map((category: any) => {
            return <tr>
                <td>{category.id}</td>
                <td>{category.name}</td>
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