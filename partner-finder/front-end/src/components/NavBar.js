import { useContext } from "react";
import { Link } from "react-router-dom";
import AuthContext from "../context/AuthContext";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function NavBar() {
  const { user, logout } = useContext(AuthContext);

  // If we have an auth.user, render a profile link and image and a logout button.
  // If we don't have an auth.user, render "Login"
  // and "Register" navigation.
  // TODO: Add profile image link
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Partner Finder</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="/">Find Partners</Nav.Link>
            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
              <NavDropdown.Item href="/about">
                About Partner Finder
              </NavDropdown.Item>
              <NavDropdown.Item href="/contact">Contact Us</NavDropdown.Item>
              {/* <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item> */}
            </NavDropdown>
            {user ? <Nav.Link href="/">Find Partners</Nav.Link> : null}
          </Nav>
          <Nav className="me-auto">
            {user ? (
              <Container>
                <Row>
                  <Col><Button variant="outline-primary" onClick={() => logout()}>Log Out</Button></Col>
                  <Col><Link className="nav-link" to="/profile">Welcome, {user.username}</Link></Col>
                </Row>
              </Container>
            ) : (
              <Container>
                <Row>
                <Col><Link className="btn btn-primary" variant="outline-success" to="/login">
                  Log In
                </Link></Col>
                <Col><Nav.Link href="/register">Register</Nav.Link></Col>
                </Row>
              </Container>
            )}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavBar;
