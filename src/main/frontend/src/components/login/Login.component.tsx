import './styles.css';
import React, {useEffect, useState} from 'react';
import SubmissionMessage from "../submisionmessage/SubmissionMessage.tsx";

const Login = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [message, setMessage] = useState('');
    const [resetKey, setResetKey] = useState<string>('');

    useEffect(() => {
        const username = localStorage.getItem('username');
        const password = localStorage.getItem('password');

        if (username && password) {
            authenticateUser(username, password);
        }
    });

    const authenticateUser = async (username: string, password: string) => {
            const encodedCredentials = btoa(`${username}:${password}`);
            const authHeader = `Basic ${encodedCredentials}`;
            const response = await fetch('http://localhost:8080/api/v1/emp', {
                headers: {
                    Authorization: authHeader,
                },
            });
            if (response.status === 200) {
                setIsLoggedIn(true);
                setMessage('You are logged in as ' + username);
            } else {
                localStorage.clear()
                setIsLoggedIn(false);
            }
    };

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const form = event.target as HTMLFormElement;
        const username = form.username.value;
        const password = form.password.value;
        localStorage.setItem('username', username);
        localStorage.setItem('password', password);
        authenticateUser(username, password);
        setResetKey(Date.now().toString());
        setMessage("Could not log in");
        form.reset();
    };

    if (isLoggedIn) {
        return <h4 className="login-title">{message}</h4>;
    }

    return (
        <div>
            <div className="login-title">
                <h4>Please sign in before using the database variant</h4>
            </div>
            <div className="login">
                <form onSubmit={handleSubmit} className="">
                    <label htmlFor="username">Username</label>
                    <input autoComplete="username" className="login-form" name="username" type="text" required/>
                    <label htmlFor="password">Password</label>
                    <input autoComplete="password" className="login-form" name="password" type="password" required/>
                    <input type="submit" className="button" value="Submit"/>
                </form>
            </div>
            <SubmissionMessage key={resetKey} message={message} />
        </div>
    );
};

export default Login;
