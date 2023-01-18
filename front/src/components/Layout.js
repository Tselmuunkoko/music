import React, { useEffect } from 'react';
import { Outlet, Link } from "react-router-dom";
import Audio from './Audio';
import {create} from '../services/detection';
import { useState } from "react";
import Card from './Card';
import { useSelector } from 'react-redux';
import YtCard from './YtCard';

const Layout = () => {
  const [name, setName] = useState("");
  const [isGlobal, setIsGlobal] = useState("");
  const musics = useSelector((state)=> state.shazam.value)
  useEffect(() => {
    console.log(musics);
  },[musics])
  let handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let res = await create(name, isGlobal)
      console.log(res)
    } catch (err) {
      console.log(err);
    }
  };
  function handleChange(e) {
    const value = e.target.value;
    setIsGlobal(value);
    console.log(isGlobal);
  }
  return (
  <div className="Layout">
  {/* <nav class="navbar navbar-expand-lg shadow-md py-2 bg-white relative flex items-center w-full justify-between">
    <div class="px-6 w-full flex flex-wrap items-center justify-between">
      <div class="flex items-center">
        <button
          class="navbar-toggler border-0 py-3 lg:hidden leading-none text-xl bg-transparent text-gray-600 hover:text-gray-700 focus:text-gray-700 transition-shadow duration-150 ease-in-out mr-2"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContentY"
          aria-controls="navbarSupportedContentY"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <svg
            aria-hidden="true"
            focusable="false"
            data-prefix="fas"
            class="w-5"
            role="img"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 448 512"
          >
            <path
              fill="currentColor"
              d="M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z"
            ></path>
          </svg>
        </button>
      </div>
      <div class="navbar-collapse collapse grow items-center" id="navbarSupportedContentY">
        <ul class="navbar-nav mr-auto lg:flex lg:flex-row">
          <li class="nav-item">
            <Link to="/" class="nav-link block pr-2 lg:px-2 py-2 text-gray-600 hover:text-gray-700 focus:text-gray-700 transition duration-150 ease-in-out" data-mdb-ripple="true" data-mdb-ripple-color="light">
              Home</Link>
          </li>
          <li class="nav-item">
            <Link to="/login" class="nav-link block pr-2 lg:px-2 py-2 text-gray-600 hover:text-gray-700 focus:text-gray-700 transition duration-150 ease-in-out" data-mdb-ripple="true" data-mdb-ripple-color="light">
            Login</Link>
          </li>
          <li class="nav-item mb-2 lg:mb-0">
            <Link class="nav-link block pr-2 lg:px-2 py-2 text-gray-600 hover:text-gray-700 focus:text-gray-700 transition duration-150 ease-in-out" data-mdb-ripple="true" data-mdb-ripple-color="light"
            to="/register">Register</Link>
          </li>
          <Outlet />
        </ul>
      </div>
    </div>
  </nav> */}
  <div class="text-center bg-gray-50 text-gray-800 py-20 px-6">
    <h1 class="text-5xl font-bold mt-0 mb-6">Record</h1>
    <h3 class="text-3xl font-bold mb-8">Record me</h3>
    <a class="inline-block px-6 py-2.5 bg-blue-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out" data-mdb-ripple="true" data-mdb-ripple-color="light" href="#!" role="button">
    <Audio/></a>
  </div>
  { musics.payload && musics.payload.shazam && musics.payload.shazam.track &&
    <div class="text-left">
      <h1 class="text-3xl font-bold mt-4 ml-8 mb-4">Results</h1>
      <div class="flex overflow-x-auto w-full">
        <Card result={musics.payload.shazam.track}/>
        {musics.payload.yt.results.map((track) => (
          <YtCard track={track}/>
        ))}
      </div>
    </div>
  }
  <div class="text-left">
    <h1 class="text-3xl font-bold mt-4 ml-8 mb-4">Top search</h1>
    <div class="flex overflow-x-auto w-full">
        <Card result={musics.payload.shazam.track}/>
        {musics.payload.yt.results.map((track) => (
          <YtCard track={track}/>
        ))}
      </div>
    </div>
  </div>
  )
};

Layout.propTypes = {};

Layout.defaultProps = {};

export default Layout;
