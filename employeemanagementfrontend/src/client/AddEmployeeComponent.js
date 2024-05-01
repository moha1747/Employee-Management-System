import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import UserService from "../service/UserService";
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
  const userId = localStorage.getItem("userId");
  const { employeeId } = useParams(); // const employeeId = localStorage.getItem("employeeId")

  const employeeData = {
    firstName,
    lastName,
    email,
    location,
    position,
    hours,
  };

  function saveEmployee(e) {
    e.preventDefault();
    if (employeeId) {
      // Check if updating
      UserService.updateEmployee(userId, employeeData, employeeId)
        .then(() => navigate(`/user/employee`))
        .catch((e) => console.log(e));
    } else {
      // Otherwise, add new employee
      UserService.addEmployee(userId, employeeData)
        .then(() => navigate(`/user/employee`))
        .catch((e) => console.log(e));
    }
  }
  useEffect(() => {
    if (employeeId) {
      // If there's an employeeId, we're in "edit" mode
      UserService.getEmployeeById(userId, employeeId)
        .then((res) => {
          const { firstName, lastName, email, location, position, hours } =
            res.data;
          setFirstName(firstName);
          setLastName(lastName);
          setEmail(email);
          setLocation(location);
          setPosition(position);
          setHours(hours);
        })
        .catch((e) => console.log(e));
    }
  }, [userId, employeeId]); // Include userId and employeeId as dependencies

  function title() {
    return employeeId ? "Update Employee" : "Add Employee";
  }

  return (
    <div>
      <div className="container12">
        <div className="title">
          {" "}
          <h2 className="text-white">{title()}</h2>
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
            <div className="button">
              <button
                onClick={(e) => saveEmployee(e)}
                className="custom-btn btn-5"
              >
                <span>Save</span>
              </button>{" "}
              <Link
                to={`/user/${userId}/employees`}
                style={{ textDecoration: "none" }}
                href=""
              >
                <button className="custom-btn btn-13">Cancel</button>
              </Link>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default AddEmployeeComponent;
