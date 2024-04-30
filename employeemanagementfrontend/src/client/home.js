import React, { useEffect, useState } from "react";
import HeaderComponent from "./HeaderComponent";
// import axios from 'axios'
import { Link } from 'react-router-dom'
import UserService from "../service/UserService";
import EmployeeTable from "./EmployeeTable"

const Home = () => {
  const [isSelected, setSelected] = useState(false)
  const employeeId = localStorage.getItem("employeeId");
  const userId = localStorage.getItem("userId");

  const [employeeArray, setEmployeeArray] = useState([]);


  useEffect(() => {
    getAllEmployee();
  }, []);

  function getAllEmployee() {
    UserService.getAllEmployee(userId, employeeArray)
      .then((res) => {
        setEmployeeArray(res.data);
        console.log(res.data);
      })
      .catch((e) => console.error(e));
  }
  function deleteEmployee(e) {
    e.preventDefault();
    UserService.deleteEmployee(userId, employeeId, employeeArray)
    .then(getAllEmployee()).catch(e => console.log(e));
  }

  
  const employeeInfo = ({employeeArray}) => {
    return (
      <div className="tableContainer">
        <li className="first__label">
          <input
            className="selector"
            type="radio"
            onClick={() => setSelected(!isSelected)}
          />
            <label className="employee">{employeeArray.firstName}</label>
        </li>
      </div>
    );
  }
  
  return (
    <>
      <HeaderComponent />
      <EmployeeTable employees={employeeArray} />
    </>
  );
};
export default Home;
