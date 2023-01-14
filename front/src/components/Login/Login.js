import React from 'react';
import { useSelector, useDispatch } from 'react-redux'
import { decrement, increment } from '../../features/counterSlice'
import './Login.css';
import { login } from '../../services/customer';

const Login = () => {
  const count = useSelector((state) => state.counter.value)
  const dispatch = useDispatch()

  return (
    <div className="Login">
      Login Component
      <div>
        <button
          aria-label="Increment value"
          onClick={() => dispatch(increment())}
        >
          Increment
        </button>
        <span>{count}</span>
        <button
          aria-label="Decrement value"
          onClick={() => dispatch(decrement())}
        >
          Decrement
        </button>
      </div>
      <div>
        <button
          onClick={() => login("habu", "habu")}>login</button>
      </div>
    </div>
  )
};

Login.propTypes = {};

Login.defaultProps = {};

export default Login;
