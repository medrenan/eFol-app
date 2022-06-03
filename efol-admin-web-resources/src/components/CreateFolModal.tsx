import React, { useState } from "react";
import { Button, Modal, ModalBody, ModalDialog, ModalFooter, ModalHeader, ModalTitle } from "react-bootstrap";

export default function CreateFolModal({fol, onChange, showModal, onSubmit}){

    const [show, setShow] = useState(false);

    return (
        <>
        <Modal show={showModal} onHide={() => setShow(false)} centered size="lg">
            <Modal.Header>
                <ModalTitle>Create FOL</ModalTitle>
            </Modal.Header>
            <Modal.Body>
                <p>input group</p>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={() => setShow(false)}>Close</Button>
                <Button variant="primary" onClick={onSubmit}>Create FOL</Button>
            </Modal.Footer>
        </Modal>
        </>
    )
}