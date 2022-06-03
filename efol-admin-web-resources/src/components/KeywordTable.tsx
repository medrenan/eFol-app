import React from "react";
import Table from 'react-bootstrap/Table'

export default function KeywordTable({keywords}){

    function renderTableRows() {
        if(!keywords) {
            return;
        }

        return keywords.map((keyword: any) => {
            return <tr>
                <td>{keyword.id}</td>
                <td>{keyword.name}</td>
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