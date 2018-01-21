// @flow
import React from 'react'
import {BrowserRouter, Route} from 'react-router-dom'
import Minutes from './Minutes'

const App = () => (
    <BrowserRouter>
        <div>
            <Route path='/minutes' component={Minutes}/>
        </div>
    </BrowserRouter>
)

export default App
