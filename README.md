# Readme

## AutoAMP (work in progress)

**AMP** = **A**lan's **M**aintenance **P**rogram

**Auto** for having the ability to **auto**matically run everything on a set schedule

![AutoAMP screenshot](https://github.com/0x416c616e/AutoAMP/blob/master/AutoAMP_screenshot.png "Screenshot of AutoAMP as of 11/6/2017")

## About

This program is not finished. It's just a GUI with non-functional buttons at this point.

It will be based loosely on a shell script I wrote a while ago, which ran routine tasks on Linux.

These are things that need to be done, but aren't fun to do manually: software updates, virus scans, and file backups.

Currently, it is not able to do anything because I haven't implemented the actions that the buttons should correspond to.
So it's basically a preview of what it will eventually be.

My original shell script performed software updates, network diagnostics, and virus scans. It should be easy enough to port those features over. However, I have yet to implement the other features, such as backups or scheduling.

There will eventually be different versions for macOS, Linux, and Windows. The GUI will be the same (JavaFX), and they will all do roughly the same things, but with different implementation details.

It is currently a BlueJ project, but I will convert it to a more traditional project in a normal IDE like NetBeans or Eclipse.

MainFX is the entry point.

### About button

This gives information abut AutoAMP.

### Run All

This buttons runs everything.

### Brief Scan

Runs a quicker but not as thorough virus scan. 

### View Logs

View logs of previous results. Things in AutoAMP are not only displayed in the window, but they are also logged to log files which can be reviewed later.

### Update AutoAMP

This will update AutoAMP.

### Thorough Scan

This will run a more in-depth but also slower scan for malware.

### Scheduling

This will allow you to set when the program should run. It can do everything automatically on a schedule, such as at 3:00am when you don't need to use your computer.

### Update OS

This will updat your operating system.

### Scan File

This will upload a file to VirusTotal and show you the results. Please note that there might be privacy concerns with using VirusTotal. Do not upload private files.

### Server Settings

You can change the settings for your file server here. This is where you will be backing up your files.

### Update Programs

This will update the programs running within your OS.

### Back Up Files

This will back up your files to the server specified in the Server Settings menu.
