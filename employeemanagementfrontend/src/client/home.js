import React, { useEffect, useState } from "react";
import HeaderComponent from "./HeaderComponent";
// import axios from 'axios'
import { Link } from 'react-router-dom'
import UserService from "../service/UserService";
import EmployeeTable from "./EmployeeTable"
import '../styles/home.css'

const Home = () => {
  const [isSelected, setSelected] = useState(false)
  const employeeId = localStorage.getItem("employeeId");
  const userId = localStorage.getItem("userId");

  const [employeeArray, setEmployeeArray] = useState([]);


  useEffect(() => {
    getAllEmployee();
  }, [userId]);

function getAllEmployee() {
  UserService.getAllEmployee(userId)
    .then((res) => {
      const sortedEmployees = res.data.sort((a, b) =>
        a.firstName.localeCompare(b.firstName)
      );
      setEmployeeArray(sortedEmployees);
      console.log(sortedEmployees);
    })
    .catch((e) => console.error(e));
}

function deleteEmployee(e) {
  e.preventDefault();
  UserService.deleteEmployee(userId, employeeId, employeeArray)
    .then(() => getAllEmployee())
    .catch((e) => console.log(e));
}

  return (
    <>
      <HeaderComponent />
      <EmployeeTable employees={employeeArray} />
    </>
  );
};
export default Home;
