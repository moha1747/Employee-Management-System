import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import EmployeeService from "../service/EmployeeService";

const AddEmployeeComponent = () => {
  /** Variables and method to collect and store inputes */
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [location, setLocation] = useState("");
  const [salary, setSalary] = useState("");
  const [position, setPosition] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const employeeData = { firstName, lastName, email, location, position, salary }; //bundle the inpute from user

  /**send data to api and navigate when succesful */
  function saveEmployee(e) {
    e.preventDefault();

    if (
      employeeData.firstName !== "" &&
      employeeData.lastName !== "" &&
      employeeData.email !== "" &&
      employeeData.salary !== "" &&
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
          setSalary(res.data.salary);
        })
        .catch((e) => console.log(e));
    }
  }, []);

  return (
    <div>
      <div className="container mt-5">
        <div className="row">
          <div className="card col-md-6 offset-md-3">
            <h2 className="text-center">{tile()}</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
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
                    value={salary}
                    onChange={(e) => setSalary(e.target.value)}
                    type="salary"
                    placeholder="Enter Salary"
                  />
                </div>
                <button
                  onClick={(e) => saveEmployee(e)}
                  className="btn btn-success"
                >
                  Save
                </button>{" "}
                <Link to={"/employee"} className="btn btn-danger" href="">
                  Cancel
                </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddEmployeeComponent;
