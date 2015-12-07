var App = React.createClass({
    getInitialState: function () {
        return ({gems: []});
    },
    componentDidMount: function () {
        client({method: 'GET', path: 'localhost:8080/gems'}).done(response => {
            this.setState({gems: response.entity._embedded.gems});
        });
    },
    render: function () {
        return (
            <GemsList gems={this.state.gems}/>
        )
    }
})