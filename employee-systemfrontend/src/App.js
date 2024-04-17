import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/header";
import AddEmployee from "./components/AddEmployee";
import './input.css'


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Header />} />
        <Route path='/employee' element={<Header />} />
        <Route path="/add-employee" element={<AddEmployee />} />
        <Route
          path="/add-employee/:id"
          element={<AddEmployee />}
        />{" "}
      </Routes>
    </BrowserRouter>
  );
}

export default App;
