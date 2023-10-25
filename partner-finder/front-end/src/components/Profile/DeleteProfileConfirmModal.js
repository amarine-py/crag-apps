import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

function DeleteProfileConfirmModal(props) {

  return (
    <>
      <Modal {...props}
        size="md"
        aria-labelledby="containd-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title>Delete Confirmation</Modal.Title>
        </Modal.Header>
        <Modal.Body>Do you really want to disable your profile? You will not be visible to other partners.</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={props.onHide}>
            Close
          </Button>
          <Button variant="danger" onClick={props.onConfirmDelete}>
            Confirm
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default DeleteProfileConfirmModal;