import React from "react";
import Table from 'react-bootstrap/Table'

export default function FolTable({fols}){

    function renderTableRows() {
        if(!fols) {
            return;
        }

        return fols.map((fol: any) => {
            return <tr>
                <td>{fol.id}</td>
                <td>{fol.equipment.name}</td>
                <td>{fol.title}</td>
                <td>{fol.applicability}</td>
                <td>{fol.issueDescription}</td>
                <td>{fol.category.name}</td>
                <td>{fol.status}</td>
                <td>{new Date(fol.issueDate).toLocaleDateString("en-US")}</td>
                <td>{fol.revisionNumber}</td>
                <td>{new Date(fol.revisionDate).toLocaleDateString("en-US")}</td>
                <td>{fol.remarks}</td>
                <td>{keywordsToStringList(fol.keywords)}</td>
                <td>{fol.folPDF ? fol.folPDF : "N/A" }</td>
            </tr>
        })
    }

    function keywordsToStringList(keywords) {
        return keywords.map((keyword) => {
            return keyword.name
        }).join(", ")
    }

    return (
        <>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Equipment</th>
                        <th>Title</th>
                        <th>Applicability</th>
                        <th>Issue Description</th>
                        <th>Category</th>
                        <th>Status</th>
                        <th>Issue Date</th>
                        <th>Revision Number</th>
                        <th>Revision Date</th>
                        <th>Remarks</th>
                        <th>Keywords</th>
                        <th>PDF</th>
                    </tr>
                </thead>
                <tbody>
                    {renderTableRows()}
                </tbody>
            </Table>
        </>
    )
}