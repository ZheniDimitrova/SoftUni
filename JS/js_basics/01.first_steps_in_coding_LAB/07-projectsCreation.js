function projectsCreation(input) {

    let name = input[0];
    let countProjects = input[1];
    let totaltime = countProjects * 3;

    console.log(`The architect ${name} will need ${totaltime} hours to complete ${countProjects} project/s.`)
}

projectsCreation(["Sanya ", "9 "]);