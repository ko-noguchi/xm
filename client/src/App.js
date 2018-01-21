import React from "react";
import {BrowserRouter, Route} from "react-router-dom";
import Minutes from "./Minutes";

export default () => (
    <BrowserRouter>
        <div>
            <Route path='/minutes' component={Minutes}/>
        </div>
    </BrowserRouter>
);
