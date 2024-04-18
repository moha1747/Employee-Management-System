import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import EmployeeService from "../service/EmployeeService";
import "../styles/add.css";

const AddEmployeeComponent = () => {
  /** Variables and method to collect and store inputes */
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [location, setLocation] = useState("");
  const [hours, setHours] = useState("");
  const [position, setPosition] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const employeeData = {
    firstName,
    lastName,
    email,
    location,
    position,
    hours,
  }; //bundle the inpute from user

  /**send data to api and navigate when succesful */
  function saveEmployee(e) {
    e.preventDefault();

    if (
      employeeData.firstName !== "" &&
      employeeData.lastName !== "" &&
      employeeData.email !== "" &&
      employeeData.hours !== "" &&
      employeeData.location !== "" &&
      employeeData.position !== ""
    ) {
      /**If id is present in the parameter, it should update else it should save */
      if (id) {
        EmployeeService.updateEmployee(id, employeeData)
          .then(navigate("/employee"))
          .catch((e) => console.log(e));
      } else {
        EmployeeService.saveEmployee(employeeData)
          .then(navigate("/employee"))
          .catch((e) => console.log(e));
      }
    } else {
      alert("Please fill in the blanks");
    }
  }

  function tile() {
    if (id) {
      return "Update Employee";
    } else {
      return "Add Employee";
    }
  }
  useEffect(() => {
    if (id) {
      EmployeeService.getEmployeeById(id)
        .then((res) => {
          setFirstName(res.data.firstName);
          setLastName(res.data.lastName);
          setEmail(res.data.email);
          setLocation(res.data.location);
          setPosition(res.data.position);
          setHours(res.data.hours);
        })
        .catch((e) => console.log(e));
    }
  }, []);

  return (
    <div>
      <div className="container1">
        <div className="title">
          {" "}
          <h2>{tile()}</h2>
        </div>
        <div className="card-body">
          <form>
            <div className="form-group">
              <input
                className="form-control"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                type="text"
                placeholder="Enter First Name"
              />
            </div>
            <div className="form-group mb-2">
              <input
                className="form-control"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                type="text"
                placeholder="Enter Last Name"
              />
            </div>
            <div className="form-group mb-2">
              <input
                className="form-control"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                type="email"
                placeholder="Enter Email"
              />
            </div>
            <div className="form-group mb-2">
              <input
                className="form-control"
                value={location}
                onChange={(e) => setLocation(e.target.value)}
                type="location"
                placeholder="Enter Location"
              />
            </div>
            <div className="form-group mb-2">
              <input
                className="form-control"
                value={position}
                onChange={(e) => setPosition(e.target.value)}
                type="Position"
                placeholder="Enter Position"
              />
            </div>
            <div className="form-group mb-2">
              <input
                className="form-control"
                value={hours}
                onChange={(e) => setHours(e.target.value)}
                type="hours"
                placeholder="Enter hours"
              />
            </div>
            <div className="button"></div>
            <button
              onClick={(e) => saveEmployee(e)}
              className="custom-btn btn-5"
            >
              <span>Save</span>
            </button>{" "}
            <Link to={"/employee"} style={{ textDecoration: "none" }} href="">
              <button className="custom-btn btn-13">Cancel</button>
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddEmployeeComponent;
