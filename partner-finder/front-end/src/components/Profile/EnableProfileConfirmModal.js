import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

function EnableProfileConfirmModal(props) {

  return (
    <>
      <Modal {...props}
        size="md"
        aria-labelledby="containd-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title>Enable Confirmation</Modal.Title>
        </Modal.Header>
        <Modal.Body>Are you sure you want to re-enable your profile? You will now be visible to other partners.</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={props.onEnableHide}>
            Close
          </Button>
          <Button variant="success" onClick={props.onConfirmEnable}>
            Confirm
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default EnableProfileConfirmModal;