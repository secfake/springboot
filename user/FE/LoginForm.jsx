import React, { useState } from "react";
import "./LoginForm.css";
const API_URL = "http://127.0.0.1:8080/login";
function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [showLogin, setShowLogin] = useState("showform");
  const [data, setData] = useState({});
  const handleSubmit = async () => {
    console.log(`Username: ${username} Password: ${password}`);
    if (username.trim() === "" || password.trim() === "") {
      alert("Username và Password không được để trống!");
      return;
    }
    try {
      const result = await fetch(API_URL, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ username: username, password: password }),
        });
      if(result.status===200){
        const res = await result.json();
        setShowLogin("hideform")
          setData(res)
          setShowLogin("hideform")
          console.log(data)
      }else{
          alert("username hoặc password chưa chính xác")
      }
      
    } catch (error) {
      console.error(error);
    }
  };

  const ShowUser = ({data})=> {
  return(
   <>
   <h2>Xin chào {data.username}</h2>
   <p>Username: {data.username}</p>
   <p>Email: {data.email}</p>
   <p>Avatar</p>
   <img src={data.avatar}  />
    </>
  )

  }
  return (
    <>
    <div className={showLogin}>
      <h2>Đăng nhập</h2>
      <label>
        Username:
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </label>
      <br />
      <label>
        Password:
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </label>
      <br />

      <button type="submit" onClick={handleSubmit}>
        Đăng nhập
      </button>
     
    </div>
    {Object.keys(data).length !== 0 && <ShowUser data={data}></ShowUser>    }
    </>
  );
}

export default LoginForm;
