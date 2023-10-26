import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

function AwardSuccessModal(props) {

  return (
    <>
      <Modal {...props}
        size="md"
        aria-labelledby="containd-modal-title-vcenter"
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title>Badge Awarded!</Modal.Title>
        </Modal.Header>
        <Modal.Body>Your partner has received this badge and will be notified.</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={props.onHide}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default AwardSuccessModal;