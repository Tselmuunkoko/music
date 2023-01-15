import React from 'react';
import { Outlet, Link } from "react-router-dom";
import Audio from '../Audio/Audio';
import './Layout.css';

const Layout = () => (
  <div className="Layout">
    <Audio/>
     <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/login">Login</Link>
          </li>
          <li>
            <Link to="/register">Register</Link>
          </li>
        </ul>
      </nav>
      <Outlet /> 
  </div>
);

Layout.propTypes = {};

Layout.defaultProps = {};

export default Layout;
