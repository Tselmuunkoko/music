import './App.css';
import * as React from "react";
import { Routes, Route} from "react-router-dom";
import Login from "./components/Login";
import Register from "./components/Register";
import Layout from './components/Layout';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route index element={<Layout/>} />
        <Route path="login" element={<Login />} />
        <Route path="register" element={<Register/>} />
      </Routes>
    </div>
  );
}

export default App;
