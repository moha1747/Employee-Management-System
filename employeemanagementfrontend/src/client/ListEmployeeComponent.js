import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { link } from 'react-router-dom'
import UserService from '../service/UserService'
const employeeId = localStorage.getItem('employeeId')
const userId = localStorage.getItem('userId')


const ListEmployeeComponent = () => {
  const [employeeArray, setEmployeeArray] = useState([])

  useEffect(() => {
    getAllEmployee()
  }, [])

  function getAllEmployee() {
    UserService.getAllEmplpoyee()
      .then((res => { setEmployeeArray(res.data); console.log(res.data) }))
    .catch((e) => console.error(e))
  }
  function deleteEmployee(e) {
    e.preventDefault();
    UserService.deleteEmployee(userId, employeeId, employeeArray)
    .then(getAllEmployee()).catch(e => console.log(e));
  }

  return (
    <div></div>
  )
}

export default ListEmployeeComponent