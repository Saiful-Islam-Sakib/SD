
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 04/08/2019 21:53:30
-- Generated from EDMX file: I:\edu\Renaissance\Renaissance\Models\DBModel.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [EducationalDB];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[Answer]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Answer];
GO
IF OBJECT_ID(N'[dbo].[Comment]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Comment];
GO
IF OBJECT_ID(N'[dbo].[Moderator]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Moderator];
GO
IF OBJECT_ID(N'[dbo].[Post]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Post];
GO
IF OBJECT_ID(N'[dbo].[Question]', 'U') IS NOT NULL
    DROP TABLE [dbo].[Question];
GO
IF OBJECT_ID(N'[dbo].[User]', 'U') IS NOT NULL
    DROP TABLE [dbo].[User];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'Answers'
CREATE TABLE [dbo].[Answers] (
    [answerId] int IDENTITY(1,1) NOT NULL,
    [userId] int  NOT NULL,
    [questionId] int  NOT NULL,
    [status] bit  NULL
);
GO

-- Creating table 'Comments'
CREATE TABLE [dbo].[Comments] (
    [commentId] int  NOT NULL,
    [postId] int  NOT NULL,
    [userId] int  NOT NULL,
    [creationDate] datetime  NULL
);
GO

-- Creating table 'Moderators'
CREATE TABLE [dbo].[Moderators] (
    [moderatorId] int  NOT NULL,
    [name] varchar(255)  NOT NULL,
    [email] varchar(255)  NOT NULL,
    [password] varchar(255)  NOT NULL
);
GO

-- Creating table 'Posts'
CREATE TABLE [dbo].[Posts] (
    [postId] int IDENTITY(1,1) NOT NULL,
    [body] varchar(3000)  NOT NULL,
    [tag] varchar(255)  NULL,
    [title] varchar(255)  NOT NULL,
    [creationDate] datetime  NULL,
    [status] bit  NULL
);
GO

-- Creating table 'Questions'
CREATE TABLE [dbo].[Questions] (
    [questionId] int IDENTITY(1,1) NOT NULL,
    [userId] int  NOT NULL,
    [Body] varchar(500)  NOT NULL,
    [Title] varchar(255)  NULL,
    [Tag] varchar(255)  NULL,
    [Answer] varchar(255)  NOT NULL,
    [Options] varchar(255)  NULL,
    [status] bit  NULL
);
GO

-- Creating table 'Users'
CREATE TABLE [dbo].[Users] (
    [userId] int IDENTITY(1,1) NOT NULL,
    [userName] varchar(255)  NOT NULL,
    [Email] varchar(255)  NOT NULL,
    [institute] varchar(255)  NULL,
    [password] varchar(255)  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [answerId] in table 'Answers'
ALTER TABLE [dbo].[Answers]
ADD CONSTRAINT [PK_Answers]
    PRIMARY KEY CLUSTERED ([answerId] ASC);
GO

-- Creating primary key on [commentId] in table 'Comments'
ALTER TABLE [dbo].[Comments]
ADD CONSTRAINT [PK_Comments]
    PRIMARY KEY CLUSTERED ([commentId] ASC);
GO

-- Creating primary key on [moderatorId] in table 'Moderators'
ALTER TABLE [dbo].[Moderators]
ADD CONSTRAINT [PK_Moderators]
    PRIMARY KEY CLUSTERED ([moderatorId] ASC);
GO

-- Creating primary key on [postId] in table 'Posts'
ALTER TABLE [dbo].[Posts]
ADD CONSTRAINT [PK_Posts]
    PRIMARY KEY CLUSTERED ([postId] ASC);
GO

-- Creating primary key on [questionId] in table 'Questions'
ALTER TABLE [dbo].[Questions]
ADD CONSTRAINT [PK_Questions]
    PRIMARY KEY CLUSTERED ([questionId] ASC);
GO

-- Creating primary key on [userId] in table 'Users'
ALTER TABLE [dbo].[Users]
ADD CONSTRAINT [PK_Users]
    PRIMARY KEY CLUSTERED ([userId] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------