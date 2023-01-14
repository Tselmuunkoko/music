import React from 'react';
import { Outlet, Link } from "react-router-dom";
import './Layout.css';

const Layout = () => (
  <div className="Layout">
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
