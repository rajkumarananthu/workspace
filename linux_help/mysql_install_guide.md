#### ---> Installing MySQL
`sudo apt-get update`
`sudo apt-get install mysql-server`
to define the root password and other security related options we need to do following:
`sudo mysql_secure_installation utility`
-> allow remote access
`sudo ufw enable`
`sudoufw allow mysql`
-> start MySQL service
`sudo systemctl start mysql`
-> launch at reboot
`sudo systemctl enable mysql`
-> restart mysql service
`sudo systemctl restart mysql`
-> configuring interfaces
``
-> Start the mysql shell
`mysql -u root -p`

**Source: https://support.rackspace.com/how-to/install-mysql-server-on-the-ubuntu-operating-system/**
